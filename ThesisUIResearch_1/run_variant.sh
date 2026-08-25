#!/bin/zsh
  
PKG="com.example.thesisuiresearch"
ACTIVITY="com.example.thesisuiresearch/.ui.ProductListActivity"
VARIANT=1
RUN=13
DURATION=15
  
OUT_CPU="cpu_variant${VARIANT}_run${RUN}.csv"
OUT_MEM="mem_variant${VARIANT}_run${RUN}.csv"
OUT_LAUNCH="launch_variant${VARIANT}_run${RUN}.txt"
OUT_FRAME="frame_variant${VARIANT}_run${RUN}.txt"
OUT_GPU="gpu_variant${VARIANT}_run${RUN}.txt"
OUT_BATTERY="battery_variant${VARIANT}_run${RUN}.txt"

echo "Starting Variant $VARIANT Run $RUN"
  
adb shell dumpsys batterystats --reset
  
adb shell am force-stop "$PKG"
    
adb shell am start -W -n "$ACTIVITY" --ei variant "$VARIANT" > "$OUT_LAUNCH"
  
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
  
  CPU=$(adb shell top -b -n 1 | grep " $PKG$" | awk '{print $9}' | tr -d '%' | head -n 1)
 	
  echo "$i,$CPU" >> "$OUT_CPU"
  echo "Second $i: $CPU"

  sleep 1
done

MEM=$(adb shell dumpsys meminfo "$PKG" | grep "TOTAL PSS" | awk '{print $3}')
MEM_MB=$(echo "scale=2; $MEM/1024" | bc)
echo "$MEM_MB" >> "$OUT_MEM"
    
adb shell dumpsys batterystats "$PKG" > "$OUT_BATTERY"
adb shell dumpsys gfxinfo "$PKG" framestats > "$OUT_FRAME"
adb shell dumpsys gfxinfo "$PKG" > "$OUT_GPU"
adb shell dumpsys batterystats "$PKG" > "$OUT_BATTERY"
  
echo "Done!"
echo "CPU -> $OUT_CPU"
echo "Memory -> $OUT_MEM"
echo "Launch time -> $OUT_LAUNCH"
echo "Frame stats -> $OUT_FRAME"
echo "GPU info -> $OUT_GPU"
echo "Battery -> $OUT_BATTERY"
