package com.zf.spring.ldap;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * @Description:拉取AD域账户*/
public class LdAPTest {
    public static void main(String[] args) {
        Properties env = new Properties();
        String adminName = "readonly";//username@domain
        String adminPassword = "Ycg@WL.com";//password
        String ldapURL = "LDAP://172.16.251.200";//ip:port
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");//"none","simple","strong"
        env.put(Context.SECURITY_PRINCIPAL, adminName);
        env.put(Context.SECURITY_CREDENTIALS, adminPassword);
        env.put(Context.PROVIDER_URL, ldapURL);
        try {
            LdapContext ctx = new InitialLdapContext(env, null);
            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String searchFilter = "objectClass=User";
//            String searchFilter = "objectClass=organizationalUnit";
            String searchBase = "OU=远成集团,DC=ycgwl,DC=com";
           // String returnedAtts[] = {"memberOf"};
          //  searchCtls.setReturningAttributes(returnedAtts);
            NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter,searchCtls);
            int i=0;
            while (answer.hasMoreElements()) {
                i++;
                SearchResult sr = (SearchResult) answer.next();
                System.out.println("<<<::[" + sr.getName()+"]::>>>>");
            }
            System.out.println(i);
            ctx.close();
        }catch (NamingException e) {
            e.printStackTrace();
            System.err.println("Problem searching directory: " + e);
        }
    }
}