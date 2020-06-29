/*
 *
 * Copyright (c) 2006-2020, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.jpastreamer.field.internal.predicate.chars;

import com.speedment.jpastreamer.field.internal.predicate.AbstractFieldPredicate;
import com.speedment.jpastreamer.field.predicate.PredicateType;
import com.speedment.jpastreamer.field.trait.HasArg0;
import com.speedment.jpastreamer.field.trait.HasCharValue;

/**
 * A predicate that evaluates if a value is {@code ==} a specified {@code char}.
 * 
 * @param <ENTITY> entity type
 * @param <D>      database type
 * 
 * @author Emil Forslund
 * @since  3.0.0
 */
public final class CharEqualPredicate<ENTITY, D>
extends AbstractFieldPredicate<ENTITY, HasCharValue<ENTITY, D>>
implements HasArg0<Character> {
    
    private final char value;
    
    public CharEqualPredicate(HasCharValue<ENTITY, D> field, char value) {
        super(PredicateType.EQUAL, field, entity -> field.getAsChar(entity) == value);
        this.value = value;
    }
    
    @Override
    public Character get0() {
        return value;
    }
    
    @Override
    public CharNotEqualPredicate<ENTITY, D> negate() {
        return new CharNotEqualPredicate<>(getField(), value);
    }
}