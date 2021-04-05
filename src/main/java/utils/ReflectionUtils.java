package utils;

public class ReflectionUtils {

    public static String getCallerMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
}
