package com.jiawa.wiki.controller;

import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.StatisticResp;
import com.jiawa.wiki.service.EbookSnapshotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ebook-snapshot")
public class EbookSnapshotController {
    @Resource
    private EbookSnapshotService ebookSnapshotService;

    @GetMapping("/get-statistic")
    public CommonResp getStatistic() {
        CommonResp<List<StatisticResp>> resp = new CommonResp();
        List<StatisticResp> statisticResp = ebookSnapshotService.getStatistic();
        resp.setContent(statisticResp);
        return resp;
    }

    @GetMapping("/get-30-statistic")
    public CommonResp get30Statistic(){
        List<StatisticResp> statisticResp = ebookSnapshotService.get30Statistic();
        CommonResp<List<StatisticResp>> resp = new CommonResp<>();
        resp.setContent(statisticResp);
        return resp;
    }
}

