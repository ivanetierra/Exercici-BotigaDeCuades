package com.whiteCollar.Exceptions;


public class ShopNotFoundException extends RuntimeException
{
    public ShopNotFoundException(Long id)
    {
        super("Could not find Shop: " + id);
    }
}
