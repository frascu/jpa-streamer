/*
 * JPAstreamer - Express JPA queries with Java Streams
 * Copyright (c) 2020-2020, Speedment, Inc. All Rights Reserved.
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * See: https://github.com/speedment/jpa-streamer/blob/master/LICENSE
 */
package com.speedment.jpastreamer.pipeline.standard.internal.terminal;

import com.speedment.jpastreamer.pipeline.terminal.TerminalOperation;
import com.speedment.jpastreamer.pipeline.terminal.TerminalOperationFunctionalType;
import com.speedment.jpastreamer.pipeline.terminal.TerminalOperationType;

import java.util.function.Consumer;
import java.util.stream.BaseStream;

import static java.util.Objects.requireNonNull;

final class AcceptTerminalOperation<S extends BaseStream<?, S>, R, F extends Consumer<S>>
        extends AbstractTerminalOperation<S, R>
        implements TerminalOperation<S, R> {

    private final F consumer;

    AcceptTerminalOperation(final TerminalOperationType type,
                            final Class<? super S> streamType,
                            final Class<? super R> returnType,
                            final F consumer,
                            final Object... arguments) {
        super(type, streamType, returnType, arguments);
        assert type.functionalType() == TerminalOperationFunctionalType.ACCEPT;
        this.consumer = requireNonNull(consumer);
    }

    @Override
    public Consumer<S> consumer() {
        return consumer;
    }
}
