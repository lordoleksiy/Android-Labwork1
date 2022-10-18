package com.example.labwork1;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

import androidx.annotation.NonNull;

public class TextTransformationMethod extends PasswordTransformationMethod {
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        return new PasswordCharSequence(source);
    }
    private static class PasswordCharSequence implements CharSequence {
        private final CharSequence text;
        public PasswordCharSequence(CharSequence source) {
            text = source;
        }
        public char charAt(int index) {
            return '*';
        }
        public int length() {
            return text.length();
        }
        @NonNull
        public CharSequence subSequence(int start, int end) {
            return text.subSequence(start, end);
        }
    }
}
