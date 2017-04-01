package com.zf.spring.durid;

import org.junit.Test;

import com.alibaba.druid.filter.config.ConfigTools;

public class DecryptDruid {
    /**
     * 对文字进行解密
     * @throws Exception
     */
    @Test
    public  void testDecrypt() throws Exception {
        //解密
        String word="IemtsDeRvJg++sxRdAE8EL/aSDQOnQLHVGAuRgZshzv4VRkr+pismGAuA8F687sZZrGhuuncGvsNT/fjNSvVuA==";
        String decryptword = ConfigTools.decrypt(word);
        System.out.println(decryptword);
    }
    /**
     * 文字进行加密
     * @throws Exception
     */
    @Test
    public void testEncrypt() throws Exception
    {
        //加密
        String password ="xxxxxxx";
        String encryptword = ConfigTools.encrypt(password);
        System.out.println(encryptword);

    }
}