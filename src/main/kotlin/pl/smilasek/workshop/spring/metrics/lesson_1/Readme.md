# Lesson 1

## About Micrometer

1. Default metrics
2. Supported monitoring systems
3. Push vs pull model
4. Hierarchical model (Spring 1) vs tag based (Spring 2+)
5. Meter filters
6. `MeterRegistry` and `MeterRegistryCustomizer`
7. `/actuator/metrics`
    1. Hierarchy
    2. Filtering by tags

## Exercises

1. Modify code which would allow to enhance each metric with `ipAddress` tag
2. Disable all metrics starting with `jvm.*` name
3. [**Optional**] Add some custom tag only for prometheus metrics
4. [**Optional**] Change metrics name from `logback.events` to `logging.events`
