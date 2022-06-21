# Lesson 2

## Metric types

1. Counter
2. Gauge
3. Timer

## How to create custom metric

1. By use of `MeterRegistry`
2. By aspect

## Exercises

1. `counter.aspect` and `timer.aspect` does not work. Investigate why and fix it.
2. Write your own gauge metric, which should monitor cache size. Cache should be list/set of some objects.
3. Why `timer.aspect.some-method` does not produce any metric?