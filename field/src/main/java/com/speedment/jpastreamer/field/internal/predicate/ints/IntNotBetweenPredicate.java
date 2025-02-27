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
import com.speedment.jpastreamer.field.predicate.trait.HasInclusion;
import com.speedment.jpastreamer.field.trait.HasArg0;
import com.speedment.jpastreamer.field.trait.HasArg1;
import com.speedment.jpastreamer.field.trait.HasIntValue;
import com.speedment.jpastreamer.field.predicate.Inclusion;
import com.speedment.jpastreamer.field.predicate.PredicateType;

import static java.util.Objects.requireNonNull;

/**
 * A predicate that evaluates if a value is not between two ints.
 * 
 * @param <ENTITY> entity type
 *
 * @author Emil Forslund
 * @since  3.0.11
 */
public final class IntNotBetweenPredicate<ENTITY>
extends AbstractFieldPredicate<ENTITY, HasIntValue<ENTITY>>
implements HasInclusion,
        HasArg0<Integer>,
        HasArg1<Integer> {
    
    private final int start;
    private final int end;
    private final Inclusion inclusion;
    
    public IntNotBetweenPredicate(
            HasIntValue<ENTITY> field,
            int start,
            int end,
            Inclusion inclusion) {
        super(PredicateType.NOT_BETWEEN, field, entity -> {
            final int fieldValue = field.getAsInt(entity);
            
            switch (inclusion) {
                case START_EXCLUSIVE_END_EXCLUSIVE :
                    return (start >= fieldValue || end <= fieldValue);
                
                case START_EXCLUSIVE_END_INCLUSIVE :
                    return (start >= fieldValue || end < fieldValue);
                
                case START_INCLUSIVE_END_EXCLUSIVE :
                    return (start > fieldValue || end <= fieldValue);
                
                case START_INCLUSIVE_END_INCLUSIVE :
                    return (start > fieldValue || end < fieldValue);
                
                default : throw new IllegalStateException("Inclusion unknown: " + inclusion);
            }
        });
        
        this.start     = start;
        this.end       = end;
        this.inclusion = requireNonNull(inclusion);
    }
    
    @Override
    public Integer get0() {
        return start;
    }
    
    @Override
    public Integer get1() {
        return end;
    }
    
    @Override
    public Inclusion getInclusion() {
        return inclusion;
    }
    
    @Override
    public IntBetweenPredicate<ENTITY> negate() {
        return new IntBetweenPredicate<>(getField(), start, end, inclusion);
    }
}
