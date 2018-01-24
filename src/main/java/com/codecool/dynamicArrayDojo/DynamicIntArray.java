package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {
    private int size;
    private int[] dynamicArray;

    public DynamicIntArray() {
        this.size = 0;
        this.dynamicArray = new int[0];
    }

    public DynamicIntArray(int size) {
        this.size = size;
        this.dynamicArray = new int[size];
    }

    public int[] getDynamicArray() {
        return dynamicArray;
    }

    public void setDynamicArray(int[] dynamicArray) {
        this.dynamicArray = dynamicArray;
    }

    @Deprecated
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int lenght() {
        return this.size;
    }

    public void add(int value) {
        this.size += 1;
        this.dynamicArray = Arrays.copyOf(this.dynamicArray, this.size);
        this.dynamicArray[this.size - 1] = value;
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException{
        validateArraySize(index);
        for (int i = index; i < this.size - 1; i++) {
            this.dynamicArray[i] = this.dynamicArray[i + 1];
        }
        this.size -= 1;
        this.dynamicArray = Arrays.copyOf(this.dynamicArray, this.size);
    }

    public void insert(int index, int value) throws ArrayIndexOutOfBoundsException{
        if (index > this.size -1) {
            add(value);
        } else {
            insertValueOnIndex(index, value);
        }
    }

    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            arrayString.append(" ");
            arrayString.append(this.dynamicArray[i]);
        }

        return arrayString.toString();
    }

    @Deprecated
    private void copyArrayToBigger() {
        int[] temp = new int[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.dynamicArray[i];
        }
        this.dynamicArray = temp;
    }

    @Deprecated
    private void copyArrayToSmaller() {
        int[] temp = new int[this.size - 1];
        for (int i = 0; i < this.size - 1; i++) {
            temp[i] = this.dynamicArray[i];
        }
        this.dynamicArray = temp;
    }

    private void validateArraySize(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > this.size - 1) {
            throw new ArrayIndexOutOfBoundsException ();
        }
    }

    private void insertValueOnIndex(int index, int value) {
        this.size += 1;
        this.dynamicArray = Arrays.copyOf(this.dynamicArray, this.size);

        for (int i = this.size - 1; i > index; i--) {
            this.dynamicArray[i] = this.dynamicArray[i - 1];
        }
        this.dynamicArray[index] = value;
    }
}
