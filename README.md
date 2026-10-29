# The Impact of UI Complexity on Performance and Energy Consumption in Mobile Applications 

An experimental Android application project investigating the relationship between **UI structural complexity, application performance, and energy consumption**.

## Research Overview

The study examines how increasing UI complexity affects Android application runtime behavior.

UI complexity is represented by:

- **UI component count**
- **View hierarchy depth**

Three UI variants were developed with increasing structural complexity while maintaining the same functionality, interaction flow, and content behavior.

The study measures:

- CPU usage
- Memory usage
- Launch time
- Frame p99
- Battery drop

The experiments were conducted under two configurations:

- **Combined** — all three UI variants are contained in one application project.
- **Only** — each UI variant is implemented as a standalone application.

## Repository Structure

```text
ThesisUIResearchRepo/
├── ThesisUIResearch_1/
├── ThesisUIResearch_2/
├── ThesisUIResearch_3/
└── README.md
