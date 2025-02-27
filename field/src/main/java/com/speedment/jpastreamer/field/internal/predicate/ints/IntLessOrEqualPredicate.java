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
package com.speedment.jpastreamer.field.internal.predicate.ints;

import com.speedment.jpastreamer.field.internal.predicate.AbstractFieldPredicate;
import com.speedment.jpastreamer.field.predicate.PredicateType;
import com.speedment.jpastreamer.field.trait.HasArg0;
import com.speedment.jpastreamer.field.trait.HasIntValue;

/**
 * A predicate that evaluates if a value is {@code <=} a specified {@code int}.
 * 
 * @param <ENTITY> entity type
 *
 * @author Emil Forslund
 * @since  3.0.0
 */
public final class IntLessOrEqualPredicate<ENTITY>
extends AbstractFieldPredicate<ENTITY, HasIntValue<ENTITY>>
implements HasArg0<Integer> {
    
    private final int value;
    
    public IntLessOrEqualPredicate(HasIntValue<ENTITY> field, int value) {
        super(PredicateType.LESS_OR_EQUAL, field, entity -> field.getAsInt(entity) <= value);
        this.value = value;
    }
    
    @Override
    public Integer get0() {
        return value;
    }
    
    @Override
    public IntGreaterThanPredicate<ENTITY> negate() {
        return new IntGreaterThanPredicate<>(getField(), value);
    }
}
