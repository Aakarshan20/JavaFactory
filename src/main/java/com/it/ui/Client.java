package com.it.ui;

import com.it.factory.BeanFactory;
import com.it.service.IAccountService;
import com.it.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        //AccountServiceImpl as = new AccountServiceImpl();
        for(int i=0; i<5; i++){
            AccountServiceImpl as = (AccountServiceImpl)BeanFactory.getBean("accountService");
            //System.out.println(as);
            as.saveAccount();
        }

        //as.saveAccount();
    }
}
