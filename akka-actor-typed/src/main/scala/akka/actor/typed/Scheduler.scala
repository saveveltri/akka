/*
 * Copyright (C) 2009-2019 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.actor.typed

import akka.actor.Cancellable
import akka.annotation.DoNotInherit

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.FiniteDuration

/**
 * The ActorSystem facility for scheduling tasks.
 *
 * For scheduling within actors `Behaviors.withTimers` should be preferred.
 *
 * Not for user extension
 */
@DoNotInherit
trait Scheduler {

  /**
   * Scala API: Schedules a Runnable to be run once with a delay, i.e. a time period that
   * has to pass before the runnable is executed.
   *
   * @throws IllegalArgumentException if the given delays exceed the maximum
   * reach (calculated as: `delay / tickNanos > Int.MaxValue`).
   *
   * Note: For scheduling within actors `Behaviors.withTimers` or `ActorContext.scheduleOnce` should be preferred.
   */
  def scheduleOnce(delay: FiniteDuration, runnable: Runnable)(implicit executor: ExecutionContext): Cancellable

  /**
   * Java API: Schedules a Runnable to be run once with a delay, i.e. a time period that
   * has to pass before the runnable is executed.
   *
   * @throws IllegalArgumentException if the given delays exceed the maximum
   * reach (calculated as: `delay / tickNanos > Int.MaxValue`).
   *
   * Note: For scheduling within actors `Behaviors.withTimers` or `ActorContext.scheduleOnce` should be preferred.
   *
   */
  def scheduleOnce(delay: java.time.Duration, runnable: Runnable, executor: ExecutionContext): Cancellable

  /**
   * FIXME docs
   * Scala API: Schedules a `Runnable` to be run repeatedly with an initial delay and
   * a frequency. E.g. if you would like the function to be run after 2
   * seconds and thereafter every 100ms you would set delay = Duration(2,
   * TimeUnit.SECONDS) and interval = Duration(100, TimeUnit.MILLISECONDS). If
   * the execution of the runnable takes longer than the interval, the
   * subsequent execution will start immediately after the prior one completes
   * (there will be no overlap of executions of the runnable). In such cases,
   * the actual execution interval will differ from the interval passed to this
   * method.
   *
   * If the `Runnable` throws an exception the repeated scheduling is aborted,
   * i.e. the function will not be invoked any more.
   *
   * @throws IllegalArgumentException if the given delays exceed the maximum
   * reach (calculated as: `delay / tickNanos > Int.MaxValue`).
   *
   * Note: For scheduling within actors `Behaviors.withTimers` should be preferred.
   *
   */
  def scheduleWithFixedDelay(
      initialDelay: FiniteDuration,
      delay: FiniteDuration,
      runnable: Runnable)( // FIXME do we want the Runnable as separate parameter list?
      implicit executor: ExecutionContext): Cancellable

  /**
   * FIXME docs
   * Java API: Schedules a `Runnable` to be run repeatedly with an initial delay and
   * a frequency. E.g. if you would like the function to be run after 2
   * seconds and thereafter every 100ms you would set delay to `Duration.ofSeconds(2)`,
   * and interval to `Duration.ofMillis(100)`. If
   * the execution of the runnable takes longer than the interval, the
   * subsequent execution will start immediately after the prior one completes
   * (there will be no overlap of executions of the runnable). In such cases,
   * the actual execution interval will differ from the interval passed to this
   * method.
   *
   * If the `Runnable` throws an exception the repeated scheduling is aborted,
   * i.e. the function will not be invoked any more.
   *
   * @throws IllegalArgumentException if the given delays exceed the maximum
   * reach (calculated as: `delay / tickNanos > Int.MaxValue`).
   *
   * Note: For scheduling in actors `Behaviors.withTimers` should be preferred.
   */
  def scheduleWithFixedDelay(
      initialDelay: java.time.Duration,
      delay: java.time.Duration,
      runnable: Runnable,
      executor: ExecutionContext): Cancellable

  /**
   * Scala API: Schedules a `Runnable` to be run repeatedly with an initial delay and
   * a frequency. E.g. if you would like the function to be run after 2
   * seconds and thereafter every 100ms you would set delay = Duration(2,
   * TimeUnit.SECONDS) and interval = Duration(100, TimeUnit.MILLISECONDS). If
   * the execution of the runnable takes longer than the interval, the
   * subsequent execution will start immediately after the prior one completes
   * (there will be no overlap of executions of the runnable). In such cases,
   * the actual execution interval will differ from the interval passed to this
   * method.
   *
   * If the `Runnable` throws an exception the repeated scheduling is aborted,
   * i.e. the function will not be invoked any more.
   *
   * @throws IllegalArgumentException if the given delays exceed the maximum
   * reach (calculated as: `delay / tickNanos > Int.MaxValue`).
   *
   * Note: For scheduling within actors `Behaviors.withTimers` should be preferred.
   *
   */
  def scheduleAtFixedRate(
      initialDelay: FiniteDuration,
      interval: FiniteDuration,
      runnable: Runnable)( // FIXME do we want the Runnable as separate parameter list?
      implicit executor: ExecutionContext): Cancellable

  /**
   * Java API: Schedules a `Runnable` to be run repeatedly with an initial delay and
   * a frequency. E.g. if you would like the function to be run after 2
   * seconds and thereafter every 100ms you would set delay to `Duration.ofSeconds(2)`,
   * and interval to `Duration.ofMillis(100)`. If
   * the execution of the runnable takes longer than the interval, the
   * subsequent execution will start immediately after the prior one completes
   * (there will be no overlap of executions of the runnable). In such cases,
   * the actual execution interval will differ from the interval passed to this
   * method.
   *
   * If the `Runnable` throws an exception the repeated scheduling is aborted,
   * i.e. the function will not be invoked any more.
   *
   * @throws IllegalArgumentException if the given delays exceed the maximum
   * reach (calculated as: `delay / tickNanos > Int.MaxValue`).
   *
   * Note: For scheduling in actors `Behaviors.withTimers` should be preferred.
   */
  def scheduleAtFixedRate(
      initialDelay: java.time.Duration,
      interval: java.time.Duration,
      runnable: Runnable,
      executor: ExecutionContext): Cancellable
}
