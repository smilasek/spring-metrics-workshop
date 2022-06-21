# Lesson 2

## Metric types

1. Counter
2. Gauge
3. Timer

## How to create custom metric

1. By use of `MeterRegistry`
2. By aspect

## Exercises

1. `counter.aspect` does not work. Investigate why and fix it.
2. Write your own gauge metric, which should monitor cache size. Cache should be list/set of some objects.
3. Why `timer.aspect.some-component-method` does not work, but `timer.aspect` works? How to solve that? Hint:
   see `@Timed` javadoc
3. Why `timer.aspect.some-internal-method` does not produce any metric?