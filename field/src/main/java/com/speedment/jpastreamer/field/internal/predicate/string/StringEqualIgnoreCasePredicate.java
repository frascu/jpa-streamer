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
package com.speedment.jpastreamer.field.internal.predicate.string;


import com.speedment.jpastreamer.field.predicate.PredicateType;
import com.speedment.jpastreamer.field.trait.HasReferenceValue;

/**
 *
 * @param <ENTITY>  the entity type
 *                *
 * @author  Per Minborg
 * @since   2.2.0
 */
public final class StringEqualIgnoreCasePredicate<ENTITY>
extends AbstractStringPredicate<ENTITY> {

    public StringEqualIgnoreCasePredicate(
            final HasReferenceValue<ENTITY, String> field,
            final String lowerCase) {

        super(PredicateType.EQUAL_IGNORE_CASE, field, lowerCase, entity -> {
            final String fieldValue = field.get(entity);
            return fieldValue != null
                && fieldValue.equalsIgnoreCase(lowerCase);
        });
    }

    @Override
    public StringNotEqualIgnoreCasePredicate<ENTITY> negate() {
        return new StringNotEqualIgnoreCasePredicate<>(getField(), get0());
    }
}
