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

import com.speedment.jpastreamer.field.internal.predicate.doubles.*;
import com.speedment.jpastreamer.field.internal.util.CollectionUtil;
import com.speedment.jpastreamer.field.method.GetDouble;
import com.speedment.jpastreamer.field.predicate.FieldPredicate;
import com.speedment.jpastreamer.field.DoubleField;
import com.speedment.jpastreamer.field.comparator.DoubleFieldComparator;
import com.speedment.jpastreamer.field.comparator.NullOrder;
import com.speedment.jpastreamer.field.internal.comparator.DoubleFieldComparatorImpl;
import com.speedment.jpastreamer.field.internal.method.GetDoubleImpl;
import com.speedment.jpastreamer.field.method.DoubleGetter;
import com.speedment.jpastreamer.field.predicate.Inclusion;
import com.speedment.jpastreamer.field.predicate.SpeedmentPredicate;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * Default implementation of the {@link DoubleField}-interface.
 * 
 * Generated by com.speedment.sources.pattern.FieldImplPattern
 * 
 * @param <ENTITY> entity type
 *
 * @author Emil Forslund
 * @since  3.0.0
 */
public final class DoubleFieldImpl<ENTITY> implements DoubleField<ENTITY> {
    
    private final Class<ENTITY> table;
    private final String columnName;
    private final GetDouble<ENTITY> getter;
    private final boolean unique;

    public DoubleFieldImpl(
            Class<ENTITY> table,
            String columnName,
            DoubleGetter<ENTITY> getter,
            boolean unique) {
        this.table = requireNonNull(table);
        this.columnName = requireNonNull(columnName);
        this.getter     = new GetDoubleImpl<>(this, getter);
        this.unique     = unique;
    }
    
    @Override
    public Class<ENTITY> table() {
        return table;
    }
    
    @Override
    public GetDouble<ENTITY> getter() {
        return getter;
    }
    
    @Override
    public boolean isUnique() {
        return unique;
    }
    
    @Override
    public DoubleFieldComparator<ENTITY> comparator() {
        return new DoubleFieldComparatorImpl<>(this);
    }
    
    @Override
    public DoubleFieldComparator<ENTITY> reversed() {
        return comparator().reversed();
    }
    
    @Override
    public DoubleFieldComparator<ENTITY> comparatorNullFieldsFirst() {
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
    public FieldPredicate<ENTITY> equal(Double value) {
        return new DoubleEqualPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> greaterThan(Double value) {
        return new DoubleGreaterThanPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> greaterOrEqual(Double value) {
        return new DoubleGreaterOrEqualPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> between(
            Double start,
            Double end,
            Inclusion inclusion) {
        return new DoubleBetweenPredicate<>(this, start, end, inclusion);
    }
    
    @Override
    public FieldPredicate<ENTITY> in(Collection<Double> values) {
        return new DoubleInPredicate<>(this, CollectionUtil.collectionToSet(values));
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notEqual(Double value) {
        return new DoubleNotEqualPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> lessOrEqual(Double value) {
        return new DoubleLessOrEqualPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> lessThan(Double value) {
        return new DoubleLessThanPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notBetween(
            Double start,
            Double end,
            Inclusion inclusion) {
        return new DoubleNotBetweenPredicate<>(this, start, end, inclusion);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notIn(Collection<Double> values) {
        return new DoubleNotInPredicate<>(this, CollectionUtil.collectionToSet(values));
    }

    @Override
    public String columnName() {
        return columnName;
    }
}