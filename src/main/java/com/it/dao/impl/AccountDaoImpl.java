package com.it.dao.impl;

import com.it.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("account created!");
    }
}
