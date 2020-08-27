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
package com.speedment.jpastreamer.field.internal;

import com.speedment.jpastreamer.field.internal.predicate.longs.*;
import com.speedment.jpastreamer.field.method.LongGetter;
import com.speedment.jpastreamer.field.LongField;
import com.speedment.jpastreamer.field.comparator.LongFieldComparator;
import com.speedment.jpastreamer.field.comparator.NullOrder;
import com.speedment.jpastreamer.field.internal.comparator.LongFieldComparatorImpl;
import com.speedment.jpastreamer.field.internal.method.GetLongImpl;
import com.speedment.jpastreamer.field.method.GetLong;
import com.speedment.jpastreamer.field.predicate.FieldPredicate;
import com.speedment.jpastreamer.field.predicate.Inclusion;
import com.speedment.jpastreamer.field.predicate.SpeedmentPredicate;

import java.util.Collection;

import static com.speedment.jpastreamer.field.internal.util.CollectionUtil.collectionToSet;
import static java.util.Objects.requireNonNull;

/**
 * Default implementation of the {@link LongField}-interface.
 * 
 * Generated by com.speedment.sources.pattern.FieldImplPattern
 * 
 * @param <ENTITY> entity type
 *
 * @author Emil Forslund
 * @since  3.0.0
 */
public final class LongFieldImpl<ENTITY> implements LongField<ENTITY> {
    
    private final Class<ENTITY> table;
    private final String columnName;
    private final GetLong<ENTITY> getter;
    private final boolean unique;

    public LongFieldImpl(
            Class<ENTITY> table,
            String columnName,
            LongGetter<ENTITY> getter,
            boolean unique) {
        this.table = requireNonNull(table);
        this.columnName = requireNonNull(columnName);
        this.getter     = new GetLongImpl<>(this, getter);
        this.unique     = unique;
    }

    @Override
    public Class<ENTITY> table() {
        return table;
    }

    @Override
    public GetLong<ENTITY> getter() {
        return getter;
    }
    
    @Override
    public boolean isUnique() {
        return unique;
    }
    
    @Override
    public LongFieldComparator<ENTITY> comparator() {
        return new LongFieldComparatorImpl<>(this);
    }
    
    @Override
    public LongFieldComparator<ENTITY> reversed() {
        return comparator().reversed();
    }
    
    @Override
    public LongFieldComparator<ENTITY> comparatorNullFieldsFirst() {
        return comparator();
    }
    
    @Override
    public NullOrder getNullOrder() {
        return NullOrder.LAST;
    }
    
    @Override
    public boolean isReversed() {
        return false;
    }
    
    @Override
    public FieldPredicate<ENTITY> equal(Long value) {
        return new LongEqualPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> greaterThan(Long value) {
        return new LongGreaterThanPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> greaterOrEqual(Long value) {
        return new LongGreaterOrEqualPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> between(
            Long start,
            Long end,
            Inclusion inclusion) {
        return new LongBetweenPredicate<>(this, start, end, inclusion);
    }
    
    @Override
    public FieldPredicate<ENTITY> in(Collection<Long> values) {
        return new LongInPredicate<>(this, collectionToSet(values));
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notEqual(Long value) {
        return new LongNotEqualPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> lessOrEqual(Long value) {
        return new LongLessOrEqualPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> lessThan(Long value) {
        return new LongLessThanPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notBetween(
            Long start,
            Long end,
            Inclusion inclusion) {
        return new LongNotBetweenPredicate<>(this, start, end, inclusion);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notIn(Collection<Long> values) {
        return new LongNotInPredicate<>(this, collectionToSet(values));
    }

    @Override
    public String columnName() {
        return columnName;
    }
}