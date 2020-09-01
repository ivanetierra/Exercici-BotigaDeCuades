package com.whiteCollar.Exceptions;

public class CollarNotFoundException extends RuntimeException
{
    public CollarNotFoundException(Long id)
    {
        super("Could not find collar: " + id);
    }
}
