package com.it.ui;

import com.it.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        AccountServiceImpl as = new AccountServiceImpl();
        as.saveAccount();
    }
}
