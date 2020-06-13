package com.speedment.jpastreamer.exception;

/**
 * {@code JpaStreamerException} is the superclass of those exceptions that can be
 * thrown during the normal operation of the JpaStreamer framework. Exceptions of
 * this type are sometimes used to wrap checked exception.
 * <p>
 * {@code JpaStreamerException} and its subclasses are <em>unchecked
 * exceptions</em>. Unchecked exceptions do <em>not</em> need to be declared in
 * a method or constructor's {@code throws} clause if they can be thrown by the
 * execution of the method or constructor and propagate outside the method or
 * constructor boundary.
 *
 * @author  Per Minborg
 * @since   0.6.0
 */
public final class JpaStreamerException extends RuntimeException {

    static final long serialVersionUID = -2376282327232872L;

    /**
     * Constructs a new {@code JpaStreamerException} with {@code null} as its
     * detail message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public JpaStreamerException() {
        super();
    }

    /**
     * Constructs a new {@code JpaStreamerException} with the specified detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later
     * retrieval by the {@link #getMessage()} method.
     */
    public JpaStreamerException(final String message) {
        super(message);
    }

    /**
     * Constructs a new {@code JpaStreamerException} with the specified detail
     * message and cause.
     * <p>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated in this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method). (A {@code null} value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     */
    public JpaStreamerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code JpaStreamerException} with the specified cause and
     * a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}). This constructor is useful for exceptions that are
     * little more than wrappers for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method). (A {@code null} value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     */
    public JpaStreamerException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or
     * disabled.
     *
     * @param message the detail message.
     * @param cause the cause. (A {@code null} value is permitted, and indicates
     * that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled or
     * disabled
     * @param writableStackTrace whether or not the stack trace should be
     * writable
     */
    protected JpaStreamerException(final String message,
                                   final Throwable cause,
                                   final boolean enableSuppression,
                                   final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}