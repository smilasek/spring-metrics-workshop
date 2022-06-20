# spring-metrics-workshop

## Agenda

1. Familiarize with project
    1. Show required dependencies
2. Micrometer - facade for metrics
    1. Different monitoring systems
    2. Push vs Pull model
    3. MeterRegistry class
    4. MeterRegistryCustomizer
3. Metrics displayed in actuator
    1. Navigate to `http://localhost:8080/actuator/metrics`
    2. Observe default metrics
    3. Check specific metric `http://localhost:8080/actuator/metrics/application.ready.time`
    3. Check specific tag `http://localhost:8080/actuator/metrics/application.ready.time?tag=tagKey:tagValue`
4. Counter
5. Gauge
6. Timer
7. Reactive streams metrics
    1. `name()` prefix -> `reactive` as a default prefix
    2. `<name>.subscribed`
    3. `<name>.flow.duration`
    4. `<name>.onNext.delay`
    5. `<name>.flux.requested`

## Useful links

* https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.metrics
* https://docs.spring.io/spring-metrics/docs/current/public/prometheus
* https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector
* 