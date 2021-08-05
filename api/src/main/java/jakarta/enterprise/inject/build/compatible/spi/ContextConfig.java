package jakarta.enterprise.inject.build.compatible.spi;

import java.lang.annotation.Annotation;
import jakarta.enterprise.context.spi.AlterableContext;

/**
 * Allows configuring custom scope and context. The only mandatory method is
 * {@link ContextConfig#implementation(Class)}, other methods are optional.
 * If they aren't called, correct value is deduced from the context implementation class.
 *
 * @param <A> The annotation type
 */
public interface ContextConfig<A extends Annotation> {
    /**
     * If implementation class is defined using {@link #implementation(Class)},
     * this method doesn't have to be called. If it is, it overrides the scope annotation
     * as defined by the implementation class.
     *
     * @return The scope of the context configuration, never {@code null}
     */
    Class<A> scope();

    /**
     * Overrides the normal/pseudo state as defined by the scope annotation.
     *
     * @param isNormal whether the scope is normal
     * @return this {@code ContextConfig}, never {@code null}
     */
    ContextConfig<A> normal(boolean isNormal);

    /**
     * Defines the context implementation class. It must be {@code public} and
     * have a {@code public} zero-parameter constructor.
     * <p>
     * The implementation class typically provides the scope annotation, and therefore
     * also whether the scope is a normal scope or pseudoscope, but this can be overridden
     * using {@link #normal(boolean)}.
     *
     * @param implementationClass context object implementation class
     * @return this {@code ContextConfig}, never {@code null}
     */
    ContextConfig<A> implementation(Class<? extends AlterableContext> implementationClass);
}
