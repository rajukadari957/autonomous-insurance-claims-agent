# Autonomous Insurance Claims Processing Agent

## Problem Statement
This project implements a lightweight autonomous agent to process First Notice of Loss (FNOL) documents.  
The agent extracts key claim information, validates mandatory fields, routes claims to appropriate workflows, and provides reasoning for routing decisions.

---

## Features
- Extracts key FNOL fields from text input
- Identifies missing or incomplete mandatory fields
- Applies business rules to route claims
- Outputs structured JSON response with reasoning

---

## Routing Rules Implemented
- **Fast-track**: Estimated damage < 25,000 and no missing fields
- **Manual Review**: Any mandatory field missing
- **Investigation Flag**: Description contains keywords like fraud, staged, inconsistent
- **Specialist Queue**: Claim type is injury

---

## Project Structure

---

## How to Run
1. Open the project in **Eclipse**
2. Run `MainApp.java`
3. FNOL input is provided as sample text inside the main method
4. Output is printed in JSON format

---

## Sample Output
```json
{
  "recommendedRoute": "Fast-track",
  "missingFields": [],
  "reasoning": "All mandatory fields are present and estimated damage is below 25,000."
}

##  Final Step
1. Add `README.md`
2. Commit → **"Add README for assessment submission"**
3. Push to GitHub

That’s it 
