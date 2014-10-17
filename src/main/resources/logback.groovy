import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.status.OnConsoleStatusListener

// always a good idea to add an on console status listener
statusListener(OnConsoleStatusListener)

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %highlight(%-5level) %logger{36} - %highlight(%msg%n)"
    }
}

logger("org.springframework", INFO) // Check out application.properties for Logging Levels
logger("org.eclipse.jetty", INFO) // Check out application.properties for Logging Levels

root(DEBUG, ["CONSOLE"])




