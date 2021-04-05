package utils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.awaitility.Awaitility.await;

public class AwaitilityHelper {

    private static final int DEFAULT_POLL_INTERVAL = 2000;
    private static final int DEFAULT_TIMEOUT = 60000;

    public static <T> T awaitConditional(String alias, Callable<T> supplier, final Predicate<? super T> predicate) {
        return await(alias).pollInterval(DEFAULT_POLL_INTERVAL, TimeUnit.MILLISECONDS)
                           .atMost(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                           .until(supplier, predicate);
    }
}
