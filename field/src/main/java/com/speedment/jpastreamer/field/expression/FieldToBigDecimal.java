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
package com.speedment.jpastreamer.field.expression;

import com.speedment.runtime.compute.ToBigDecimal;
import com.speedment.runtime.compute.ToBigDecimalNullable;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Specific {@link FieldMapper} implementation that also implements
 * {@link ToBigDecimalNullable}.
 *
 * @param <ENTITY>  the entity type
 * @param <T>       the column type before mapped
 *
 * @author Emil Forslund
 * @since  3.1.0
 */
public interface FieldToBigDecimal<ENTITY, T>
extends FieldMapper<ENTITY, T, BigDecimal, ToBigDecimal<ENTITY>, Function<T, BigDecimal>>,
        ToBigDecimalNullable<ENTITY> {}
