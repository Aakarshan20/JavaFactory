package com.it.service.impl;

import com.it.service.dao.IAccountDao;
import com.it.service.IAccountService;
import com.it.service.dao.impl.AccountDaoImpl;
/*
*帳戶的業務層實現類
* */

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
