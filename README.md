# Lab 06 — Patterns and Primes

| | |
|---|---|
| **Week** | 6 |
| **Textbook** | Liang — **Chapter 5** (Nested Loops, `break` and `continue`) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Write a nested loop in which the inner bound depends on the outer counter.
2. Explain where `println()` belongs relative to the inner loop.
3. Implement a primality test with a boolean flag.
4. Use `break` to leave a loop as soon as the answer is known.
5. Reason informally about how much work a nested loop performs.

---

## Background

**Nested loops.** The inner loop runs to completion for **every** iteration of the outer loop:

```java
for (int r = 1; r <= rows; r++) {      // OUTER: one iteration per row
    for (int c = 1; c <= r; c++) {     // INNER: bound depends on r, so rows grow
        System.out.print("*");         // print, so the row stays on one line
    }
    System.out.println();              // AFTER the inner loop: ends the row
}
```

Move that `println()` inside the inner loop and you get one asterisk per line. That single line's
placement is the whole lesson.

**Primality with a flag.** A number is prime when nothing between 2 and *n* − 1 divides it evenly:

```java
boolean isPrime = true;                 // assume prime until a divisor is found
for (int d = 2; d < candidate; d++) {
    if (candidate % d == 0) {           // an exact divisor disproves primality
        isPrime = false;
        break;                          // no reason to keep testing
    }
}
```

By definition 0 and 1 are not prime, which is why the search starts at 2.

**Why the prompt needs a header.** `System.out.print("Enter the number of rows: ")` leaves the
cursor on the same line, so your first row of asterisks would be appended to the prompt. Printing
the header line `Triangle:` with `println` moves the cursor down first. The test driver requires it.

---

## Instructions

### Part A — Triangle (Steps 1–2)

After reading `rows`, print the header line `Triangle:`, then draw a left-aligned right triangle.
For `rows = 4`:

```
Triangle:
*
**
***
****
```

### Part B — Primes (Steps 3–6)

Read `limit`, print the label `Primes: ` with `print`, then list every prime from 2 through
`limit` separated by single spaces, end the line, and report the count:

```
Primes: 2 3 5 7 11 13 17 19
Prime count: 8
```

Use `break` in the inner loop. Count the primes as you print them; do not loop a second time.

---

## Commenting Standard (20 points)

```java
// WEAK
System.out.println(); // new line

// STRONG
// Placed AFTER the inner loop so the row of asterisks is terminated exactly once
// per row; inside the inner loop this would print one asterisk per line.
System.out.println();
```

---

## Compile, Run, and Test

```bash

```

---

## Sample Run

```
Enter the number of rows: 5
Triangle:
*
**
***
****
*****
Enter the upper limit: 20
Primes: 2 3 5 7 11 13 17 19
Prime count: 8
```

**Cases the driver checks:** `5 rows / limit 20` · `3 rows / limit 2` (smallest prime) ·
`1 row / limit 1` (**no primes exist**, so the count is 0) · `2 rows / limit 50` (15 primes).

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 15 checks pass | 60 |
| Line comments explain both loop bounds and the flag logic | 20 |
| Correct `println` placement, `break` used, no duplicated work | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab06` reports 15 of 15.
- [ ] A limit of 1 reports `Prime count: 0` rather than crashing or reporting 1.
- [ ] The triangle has exactly `rows` rows and no extra blank line.

```bash
git add . && git commit -m "Lab 06 complete - all 15 checks passing" && git push
```

---

## Stretch Goal

The inner loop tests every divisor up to `candidate - 1`, which is wasteful: no divisor can exceed
the square root of the candidate. Change the bound to `d * d <= candidate` and time both versions
with a limit of 200000 using `System.nanoTime()`. Report the speedup in a comment. Explain in one
sentence why the square-root bound is sufficient.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| One asterisk per line | `println` inside the inner loop | Move it after the inner loop |
| A rectangle instead of a triangle | Inner bound is `rows`, not `r` | Use `c <= r` |
| First row is stuck to the prompt | Missing the `Triangle:` header | Print the header with `println` |
| 1 is reported as prime | Candidate loop starts at 1 | Start at 2 |
| Every number is reported as prime | Flag never reset, or divisor loop starts at 1 | Reset inside the outer loop; start divisors at 2 |

