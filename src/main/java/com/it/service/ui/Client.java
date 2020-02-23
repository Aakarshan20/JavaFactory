package com.it.service.ui;

import com.it.service.IAccountService;
import com.it.service.impl.AccountServiceImpl;

/**
 * 模擬一個表現層 用於調用業務層
 */

public class Client {
    public static void main(String[] args) {
        IAccountService as = new AccountServiceImpl();
        as.saveAccount();
    }
}
