# The Impact of UI Complexity on Performance and Energy Consumption in Mobile Applications

This repository contains the Android application projects and ADB-based
measurement scripts for a study comparing UI structural complexity and
Android runtime behavior.

## Research overview

The study compares three Android UI variants with different structural
complexity. UI complexity is represented by:

-   Number of UI components
-   View hierarchy depth

The measured runtime metrics include CPU usage, memory usage, launch
time, frame-rendering metrics, and battery-percentage drop.

Two application configurations were used:

-   **Combined:** all three UI variants are available within one
    application project.
-   **Only:** a single UI variant is implemented in a standalone
    project.

Because component count and hierarchy depth both change across the
variants, the design compares the overall variants but does not isolate
the independent effect of each complexity measure.

## Repository structure

``` text
UI-Complexity-Research/
├── SCRIPTS/
│   └── ADB measurement scripts
├── DATA/
│   └── ADB measurement result spreadsheet
├── ThesisUIResearch/
├── ThesisUIResearch_1/
├── ThesisUIResearch_2/
├── ThesisUIResearch_3/
└── README.md
```

-   `SCRIPTS/` contains the scripts used for ADB-based measurement.
-   `ThesisUIResearch/` and `ThesisUIResearch_1/` through
    `ThesisUIResearch_3/` contain the Android project configurations
    used in the research. Check each project before running it to
    confirm whether it corresponds to the Combined or Only condition and
    which variant it implements.

The Excel workbook containing the processed run-level measurements
should also be added to this repository. Once uploaded, add its exact
filename here so readers can identify the data file used for the paper.

## Requirements

-   macOS or Linux terminal
-   Android Platform Tools (`adb`) installed and available on `PATH`
-   Android device connected over USB
-   Developer options and USB debugging enabled
-   USB debugging authorization granted to the connected computer
-   The corresponding research app installed on the device

The measurement script provided for Variant 1 expects package
`com.example.thesisuiresearch` and activity
`com.example.thesisuiresearch/.ui.ProductListActivity`. Confirm that
these match the build installed on the phone before running the script.

## Run the ADB measurement script

### 1. Clone the repository

``` bash
git clone https://github.com/olynsn15/UI-Complexity-Research.git
cd UI-Complexity-Research
```

### 2. Connect and verify the Android device

Connect and unlock the phone, approve the USB debugging prompt, and run:

``` bash
adb devices
```

Continue when the device appears with status `device`. If the device
appears as `unauthorized`, approve the prompt on the phone and run
`adb devices` again.

### 3. Prepare the device and run the script

The scripts are stored in `SCRIPTS/`. For the Variant 1 script, run:

``` bash
adb shell am kill-all
adb shell settings put global auto_sync 0
cd SCRIPTS
chmod +x run_variant1.sh
./run_variant1.sh
```

Use the corresponding script filename for another variant if it is
provided in `SCRIPTS/`. Before execution, inspect the script and confirm
its variant, run identifier, package/activity, and output filenames. Use
a unique run identifier to avoid overwriting earlier output files. The
script does not automatically switch between separate Combined and Only
app builds; install or select the intended project build before
collecting measurements.

### What the commands do

-   `adb devices` lists devices visible to ADB.

-   `adb shell am kill-all` asks Android to terminate background
    processes where permitted.

-   `adb shell settings put global auto_sync 0` disables Android's
    global automatic account-sync setting. This changes device settings.
    If automatic sync was enabled before testing, restore it after
    testing with:

    ``` bash
    adb shell settings put global auto_sync 1
    ```

-   `chmod +x run_variant1.sh` makes the script executable.

-   `./run_variant1.sh` executes the Variant 1 script.

## Measurement and data notes

The scripts collect selected Android runtime information and save
command outputs. The launch-time value used in the study is `TotalTime`
from the output of `adb shell am start -W`.

The scripts should not be treated as a complete automated analysis
pipeline unless the relevant parsing steps are also present. In
particular, the supplied Variant 1 script saves graphics-related reports
but does not itself parse every report into all frame/GPU percentile and
janky-frame metrics reported in the workbook.

The processed Excel workbook should be used as the run-level data source
for the reported analysis. Complete raw ADB logs for every analyzed run
are not currently included, so the repository does not provide full
end-to-end reproduction of every reported metric from raw logs alone.

## Reported experimental conditions

The measurements were collected using a Samsung Galaxy A53 running
Android 16 and One UI 7.0. Reported conditions included 50% screen
brightness, Airplane Mode, other apps closed, animations disabled in
Developer Options, and testing in the same room. The approximate
interval between runs was one minute. The fixed order was Combined
Variants 1, 2, and 3, followed by Only Variants 1, 2, and 3.

Battery observations were collected separately by leaving one variant
open for 10 minutes without connecting the phone to a laptop and
recording the displayed battery-percentage change at 50% brightness.
These observations are coarse battery-percentage measurements, not
direct measurements of energy consumption.

## Limitations

-   Component count and hierarchy depth both change across variants, so
    their independent effects cannot be isolated by this design.
-   Combined and Only represent different application/project contexts,
    so their absolute values should not be interpreted as a pure
    UI-complexity effect without considering those differences.
-   The run order was fixed rather than randomized.
-   Battery-percentage observations are descriptive and should not be
    interpreted as direct energy measurements.
-   Complete raw ADB logs for all analyzed runs and a complete automated
    parsing pipeline are not included.

## Repository link

<https://github.com/olynsn15/UI-Complexity-Research>
