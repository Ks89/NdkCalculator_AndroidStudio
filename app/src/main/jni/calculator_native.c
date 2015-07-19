/*
 * Copyright (C) 2015 Stefano Cappa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <jni.h>
#include <stdio.h>

jint
Java_it_stefanocappa_ndkcalculator_Calculator_sum( JNIEnv* env, jobject thiz, jint a, jint b ) {
    jint result = a + b;
    return result;
}

jint
Java_it_stefanocappa_ndkcalculator_Calculator_mult( JNIEnv* env, jobject thiz, jint a, jint b ) {
    jint result = a * b;
    return result;
}

jint
Java_it_stefanocappa_ndkcalculator_Calculator_div( JNIEnv* env, jobject thiz, jint a, jint b ) {
    jint result = a / b;
    return result;
}