package com.yupaits.docs.entity.auditor;

import com.yupaits.docs.common.constants.DocsConsts;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author yupaits
 * @date 2018/8/11
 */
@Component
public class DocsAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return StringUtils.isBlank(username) ? DocsConsts.DEV_USERNAME : username;
    }
}