package com.estsoft.muvigram.injection.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by jaylim on 11/2/2016.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ParentFragment {
}
