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

import com.speedment.jpastreamer.field.BooleanField;
import com.speedment.jpastreamer.field.internal.comparator.BooleanFieldComparatorImpl;
import com.speedment.jpastreamer.field.internal.method.GetBooleanImpl;
import com.speedment.jpastreamer.field.predicate.FieldPredicate;
import com.speedment.jpastreamer.field.comparator.BooleanFieldComparator;
import com.speedment.jpastreamer.field.comparator.NullOrder;
import com.speedment.jpastreamer.field.internal.predicate.booleans.BooleanEqualPredicate;
import com.speedment.jpastreamer.field.internal.predicate.booleans.BooleanNotEqualPredicate;
import com.speedment.jpastreamer.field.method.BooleanGetter;
import com.speedment.jpastreamer.field.method.GetBoolean;
import com.speedment.jpastreamer.field.predicate.SpeedmentPredicate;

import javax.persistence.AttributeConverter;

import static java.util.Objects.requireNonNull;

/**
 * Default implementation of the {@link BooleanField}-interface.
 * 
 * Generated by com.speedment.sources.pattern.BooleanFieldImplPattern
 * 
 * @param <ENTITY> entity type
 *
 * @author Emil Forslund
 * @since  3.0.0
 */
public final class BooleanFieldImpl<ENTITY> implements BooleanField<ENTITY> {
    
    private final Class<ENTITY> table;
    private final String columnName;
    private final GetBoolean<ENTITY> getter;
    private final boolean unique;

    public BooleanFieldImpl(
            Class<ENTITY> table,
            String columnName, BooleanGetter<ENTITY> getter,
            boolean unique) {
        this.table = requireNonNull(table);
        this.columnName = requireNonNull(columnName);
        this.getter     = new GetBooleanImpl<>(this, getter);
        this.unique     = unique;
    }

    @Override
    public Class<ENTITY> table() {
        return table;
    }

    @Override
    public GetBoolean<ENTITY> getter() {
        return getter;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }
    
    @Override
    public BooleanFieldComparator<ENTITY> reversed() {
        return new BooleanFieldComparatorImpl<>(this).reversed();
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
    public FieldPredicate<ENTITY> equal(boolean value) {
        return new BooleanEqualPredicate<>(this, value);
    }
    
    @Override
    public SpeedmentPredicate<ENTITY> notEqual(boolean value) {
        return new BooleanNotEqualPredicate<>(this, value);
    }

    @Override
    public String columnName() {
        return columnName;
    }
}