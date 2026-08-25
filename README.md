# Thesis UI Research

An experimental Android application project developed to investigate the relationship between **UI structural complexity, application performance, and energy consumption**.

This repository contains three UI variants with different component counts and view hierarchy depths. The variants were developed as part of a quantitative experimental study on the impact of UI complexity on Android application runtime behavior.

---

## Research Overview

This study investigates how increasing UI structural complexity affects the performance and energy consumption of Android applications.

UI complexity is represented through two structural characteristics:

- **UI component count**
- **View hierarchy depth**

Three UI variants were developed with progressively increasing structural complexity while maintaining the same application functionality, interaction flow, and content behavior.

The study evaluates the following runtime metrics:

- CPU usage
- Memory usage
- Launch time
- Frame p99
- Janky frames
- Battery drop

The experiments were conducted under two configurations:

- **Combined** — all three UI variants are contained within a single application project.
- **Only** — each UI variant is implemented as an independent standalone application.

---

## Research Questions

The study addresses the following research questions:

1. **To what extent does UI complexity affect mobile application performance and energy consumption?**
2. **How does UI complexity relate statistically to performance and energy metrics?**

---

## Repository Structure

```text
ThesisUIResearchRepo/
│
├── ThesisUIResearch_1/
│   ├── app/
│   ├── gradle/
│   ├── build.gradle
│   ├── settings.gradle
│   └── ...
│
├── ThesisUIResearch_2/
│   ├── app/
│   ├── gradle/
│   ├── build.gradle
│   ├── settings.gradle
│   └── ...
│
├── ThesisUIResearch_3/
│   ├── app/
│   ├── gradle/
│   ├── build.gradle
│   ├── settings.gradle
│   └── ...
│
└── README.md
````

Each `ThesisUIResearch_X` directory is a separate Android Studio project representing one UI complexity level.

---

## UI Variants

### Variant 1

**Variant 1** represents the lowest level of UI structural complexity.

Characteristics:

* Lower number of UI components
* Shallower view hierarchy
* RecyclerView-based interface
* Same functionality and interaction flow as the other variants

### Variant 2

**Variant 2** represents an intermediate level of UI structural complexity.

Characteristics:

* Increased number of UI components compared with Variant 1
* Deeper view hierarchy
* Same application functionality and interaction flow

### Variant 3

**Variant 3** represents the highest level of UI structural complexity.

Characteristics:

* Highest number of UI components
* Deepest view hierarchy
* Same functionality and interaction flow as Variants 1 and 2

The variants were designed so that component count and hierarchy depth were the primary structural differences between configurations.

---

## Experimental Configurations

### Combined

In the **Combined** configuration, all three UI variants are contained within a single Android application project.

This configuration allows the variants to be accessed within the same application environment and was used to observe whether the presence of multiple UI configurations affected runtime behavior.

### Only

In the **Only** configuration, each UI variant is implemented as an independent Android application project.

This configuration provides a more isolated environment for each UI complexity level.

The comparison between Combined and Only was used to examine whether project structure influenced the absolute runtime measurements while preserving the overall trends across UI complexity levels.

---

## Experimental Setup

The prototype uses a `RecyclerView`-based interface containing approximately 20 list items displayed on a single screen.

To maintain comparability across variants, the applications share:

* The same application logic
* The same screen purpose
* The same interaction flow
* The same static content behavior
* Placeholder image assets
* Local SQLite data

UI complexity was varied primarily through:

* Component count
* View hierarchy depth

The hierarchy structure of each variant was examined using Android Studio's **Layout Inspector** and **Component Tree** tools.

---

## Technology Stack

| Technology                 | Purpose                                       |
| -------------------------- | --------------------------------------------- |
| Kotlin                     | Android application development               |
| Android Studio             | Application development and profiling         |
| Android SDK                | Android application framework                 |
| RecyclerView               | List-based UI implementation                  |
| SQLite                     | Local structured data storage                 |
| Android Debug Bridge (ADB) | Runtime measurement and experiment automation |
| Android Studio Profiler    | Runtime performance observation               |

---

## Performance Metrics

The experiment measures several runtime performance indicators.

### CPU Usage

CPU utilization represents the processor workload during application execution and scrolling.

Higher CPU utilization may indicate greater computational workload associated with UI processing and rendering.

### Memory Usage

Memory usage represents the amount of system memory utilized by the application during execution.

It provides an indication of the memory resources required by different UI structures.

### Launch Time

Launch time measures the time required for the application to reach its initial rendered state after being launched.

This metric provides an indication of startup overhead.

### Frame p99

Frame p99 represents the 99th-percentile frame rendering time.

It is used to observe higher-latency frame behavior while reducing the influence of extreme outlier values.

### Janky Frames

Janky frames represent frames that exceed the expected rendering time budget and may contribute to visibly less smooth interactions.

---

## Energy Observation

Battery consumption was evaluated through a separate supporting experiment.

Each UI variant was:

* Opened individually
* Kept active on screen for approximately 10 minutes
* Tested with screen brightness maintained at approximately 50%
* Measured based on battery percentage before and after the observation period

Battery percentage drop was used as an indication of relative energy consumption behavior.

Because battery percentage measurements have limited granularity and are affected by system-level variability, the battery results are interpreted as **supporting evidence rather than precise power measurements**.

---

## Experimental Procedure

Each UI configuration was executed **10 times** following three preliminary warm-up runs.

The warm-up runs were excluded from the final analysis to reduce the influence of:

* Resource loading
* Caching behavior
* Layout inflation
* Android Runtime (ART) optimization

For each performance trial:

1. The application was force-stopped.
2. The application was launched.
3. Initial launch/rendering time was recorded.
4. A controlled scrolling interaction was performed for approximately 15 seconds.
5. CPU usage was sampled during the scrolling phase.
6. Memory and frame-related metrics were collected after the run.
7. Raw measurements were recorded for subsequent analysis.

An ADB-based script was used to partially automate the application lifecycle, scrolling interaction, and timing to improve consistency between trials.

---

## Data Analysis

The collected data were analyzed using descriptive and inferential statistics.

### Descriptive Analysis

Mean and standard deviation were calculated to summarize the measurements obtained from repeated experimental runs.

### Pearson Correlation

Pearson correlation was used to examine the strength and direction of the relationship between UI complexity and the measured performance and energy metrics.

The analysis considered the complete set of observations rather than only the averaged values.

A significance level of:

```text
α = 0.05
```

was used to evaluate statistical significance.

### Visualization

Scatter plots with regression lines were generated for selected metrics to visualize the relationship between UI complexity and runtime measurements.

---

## Experimental Device

The experiment was conducted using:

**Samsung Galaxy A53**

The device represents a mid-tier Android smartphone and was kept consistent throughout the experiment to minimize variation caused by differences in hardware.

---

## Limitations

The results of this study should be interpreted within the scope of the experimental setup.

The main limitations include:

* The experiment was conducted on a **single Android device**, so results may differ on devices with different hardware configurations.
* The prototype used a **RecyclerView-based UI pattern**, and other UI architectures or interaction patterns may produce different results.
* The experiment was conducted under **controlled conditions**, which may not fully represent highly complex production applications or real-world usage scenarios.
* The number of measured performance and energy parameters was limited to the metrics included in this study.
* The experimental duration was relatively short, particularly for the battery observation.
* The battery measurement relied on battery percentage changes rather than direct power or energy measurements.
* The study did not include human participants, usability testing, or qualitative evaluation of user experience.

Future work may extend the experiment across multiple Android devices, incorporate additional UI patterns and application structures, and evaluate longer-term usage scenarios.

---

## Project Purpose

This repository is intended to support the experimental investigation presented in the associated research paper/thesis:

> **The Impact of UI Complexity on Performance and Energy Consumption in Mobile Applications**

The project focuses specifically on the relationship between **UI structural characteristics** and measurable runtime behavior rather than evaluating visual design quality or user preferences.

---

## Repository Notes

The three projects are intentionally maintained under a single root repository for easier comparison and version management.

Each project contains its own Android Studio project configuration and can be opened independently.

The `.git` directory exists only at the repository root:

```text
ThesisUIResearchRepo/
└── .git/
```

The individual variant directories do not contain separate Git repositories.

---

## Author

**Carolyn Santana**

Android / Mobile Application Research

---

## Academic Context

This repository was developed as part of an undergraduate research project investigating mobile application performance, UI complexity, and energy consumption on Android devices.

```
```
