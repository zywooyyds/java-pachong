package com.ck.ko;


import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * <b>description</b>：第一个爬虫示例，爬去动作片列表信息 <br>
 * <b>time</b>：2019/4/20 10:58 <br>
 * <b>author</b>：ready likun_557@163.com
 */
@Slf4j
public class Ady01comPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        log.info("爬取成功!");
        log.info("爬取的内容：" + page.getRawText());
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(1000).setRetryTimes(3);
    }

    public static void main(String[] args) {
        String url = "https://so.csdn.net/so/search?q=flowable&t=blog&u=weixin_44663675";
        Spider.create(new Ady01comPageProcessor()).addUrl(url).thread(1).run();
    }
}
