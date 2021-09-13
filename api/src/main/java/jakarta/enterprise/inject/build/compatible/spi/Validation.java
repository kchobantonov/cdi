package jakarta.enterprise.inject.build.compatible.spi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 5th phase of CDI Lite extension execution.
 * Allows custom validation.
 * <p>
 * Methods annotated {@code @Validation} can define parameters of these types:
 * <ul>
 * <li>{@link Messages}: to produce log messages and validation errors</li>
 * </ul>
 * If you need to create instances of {@link jakarta.enterprise.lang.model.types.Type Type}, you can also declare
 * a parameter of type {@link Types}. It provides factory methods for the void pseudo-type, primitive types,
 * class types, array types, parameterized types and wildcard types.
 *
 * @since 4.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validation {
}