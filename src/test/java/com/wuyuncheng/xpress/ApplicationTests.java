package com.wuyuncheng.xpress;

import com.wuyuncheng.xpress.model.dao.MetaDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private MetaDAO metaDAO;

    @Test
    public void contextLoads() {
    }

}
