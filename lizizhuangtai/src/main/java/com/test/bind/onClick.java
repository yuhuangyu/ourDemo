package com.test.bind;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fj on 2018/8/28.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@EventType(listenerType = View.OnClickListener.class, listenerSetter = "setOnClickListener", methodName = "onClick")
public @interface onClick {
    int[] value();
}
