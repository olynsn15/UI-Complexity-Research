!/bin/zsh

PKG="com.example.thesisuiresearch"
ACTIVITY="com.example.thesisuiresearch/.ui.ProductListActivity"
VARIANT=2
RUN=1
DURATION=15

OUT_CPU="cpu_variant${VARIANT}_run${RUN}.csv"
OUT_MEM="mem_variant${VARIANT}_run${RUN}.csv" 
  
echo "Starting Variant $VARIANT Run $RUN"
    
adb shell am force-stop "$PKG"
adb shell am start -n "$ACTIVITY" --ei variant "$VARIANT"

sleep 3
  
echo "second,cpu" > "$OUT_CPU"
echo "memory_mb" > "$OUT_MEM"

echo "Start scrolling + CPU sampling..."

for ((i=1; i<=DURATION; i++)); do
  if (( i % 2 == 0 )); then
    adb shell input swipe 500 300 500 1500 300
  else
    adb shell input swipe 500 1500 500 300 300
  fi

  CPU=$(adb shell top -b -n 1 | grep "$PKG" | awk '{print $9}')

  echo "$i,$CPU" >> "$OUT_CPU"
  echo "Second $i: $CPU"

  sleep 1
done

MEM=$(adb shell dumpsys meminfo "$PKG" | grep "TOTAL PSS" | awk '{print $3}')
MEM_MB=$(echo "scale=2; $MEM/1024" | bc)
  
echo "$MEM_MB" >> "$OUT_MEM"
  
echo "Done!"
echo "CPU saved to $OUT_CPU"
echo "Memory saved to $OUT_MEM"
