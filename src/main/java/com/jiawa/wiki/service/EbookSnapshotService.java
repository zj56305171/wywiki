package com.jiawa.wiki.service;

import com.jiawa.wiki.mapper.EbookSnapshotMapperCust;
import com.jiawa.wiki.resp.StatisticResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EbookSnapshotService{
    @Resource
    private EbookSnapshotMapperCust ebookSnapshotMapperCust;

    public void genSnapshot(){
        ebookSnapshotMapperCust.genSnapshot();
    }

    /**
     * 获取首页数值数据：总阅读数，总点赞数，今日阅读数，今日点赞数
     * @return
     */
    public List<StatisticResp> getStatistic(){
        return ebookSnapshotMapperCust.getStatistic();
    }

    /**
     * 获取30天数值统计
     * @return
     */
    public List<StatisticResp> get30Statistic(){
        return ebookSnapshotMapperCust.get30Statistic();
    }



}
