/*
* File Name: OutOfBoundaryException.java
* Written by: Xiaoran Du
* Description: create OutofBoundaryException
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the OutOfBoundaryException java class.
*/

package com.project.xda4;

public class OutOfBoundaryException extends Exception{
    public OutOfBoundaryException(String error) {
        super( error);
    }
}
