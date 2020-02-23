package com.it.service.impl;

import com.it.dao.impl.AccountDaoImpl;
import com.it.factory.BeanFactory;
import com.it.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    //private AccountDaoImpl accountDao = new AccountDaoImpl();
    private AccountDaoImpl accountDao = (AccountDaoImpl)BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
