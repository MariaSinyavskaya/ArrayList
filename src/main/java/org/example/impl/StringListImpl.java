package org.example.impl;

import org.example.exceptions.*;
import org.example.interfaces.StringList;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private static final int DEFAULT_CAPACITY = 10;

    private String[] array;
    private int size;

    public StringListImpl() {
        array = new String[DEFAULT_CAPACITY];
    }

    public StringListImpl(int initialCapacity) {
        array = new String[initialCapacity];
    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItem(item);
        validateSize();
        if (index == size) {
            array[size++] = item;
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size ++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size --;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = get(index);
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size --;
        return item;
    }

    @Override
    public boolean contains(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (Arrays.equals(this.toArray(), otherList.toArray())) {
            return true;
        }
        if (otherList == null) {
            throw new NullObjectException();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }
}
