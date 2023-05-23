/*
* File Name: PenSize.java
* Written by: Xiaoran Du
* Description: Use enum PenSize to define different pen sizes.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the PenSize java class.
*/

package com.project.xda4;

public enum PenSize {
    SMALL(2),
    MEDIUM(4),
    LARGE(6);
    private final int penSize;

    PenSize(int penSize) {
        this.penSize = penSize;
    }

    public int getPenSize() {
        return penSize;
    }
}
