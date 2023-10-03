package com.dapascript.sample.data.source

import com.dapascript.sample.data.model.PackageEntity
import com.dapascript.sample.data.model.RoamingEntity

object PackageInternet {
    fun packageInternet(): List<PackageEntity> {
        val list = mutableListOf<PackageEntity>()
        list.add(
            PackageEntity(
                "2 GB",
                "30 Hari",
                20000
            )
        )
        list.add(
            PackageEntity(
                "50 GB",
                "30 Hari",
                300000
            )
        )
        list.add(
            PackageEntity(
                "20 GB",
                "30 Hari",
                150000
            )
        )
        list.add(
            PackageEntity(
                "1 GB",
                "20 Hari",
                10000
            )
        )
        list.add(
            PackageEntity(
                "10 GB",
                "30 Hari",
                80000
            )
        )
        list.add(
            PackageEntity(
                "5 GB",
                "30 Hari",
                50000
            )
        )
        list.add(
            PackageEntity(
                "3 GB",
                "30 Hari",
                30000
            )
        )
        list.add(
            PackageEntity(
                "1 GB",
                "30 Hari",
                20000
            )
        )
        list.add(
            PackageEntity(
                "500 MB",
                "30 Hari",
                10000
            )
        )
        list.add(
            PackageEntity(
                "200 MB",
                "30 Hari",
                5000
            )
        )
        return list
    }

    fun roaming(): List<RoamingEntity> {
        val list = mutableListOf<RoamingEntity>()
        list.add(
            RoamingEntity(
                "Singapura",
                "Rp 10.000 / 1 MB",
                300000
            )
        )
        list.add(
            RoamingEntity(
                "Malaysia",
                "Rp 5000 / 1 MB",
                200000
            )
        )
        list.add(
            RoamingEntity(
                "Thailand",
                "Rp 5000 / 1 MB",
                210000
            )
        )
        list.add(
            RoamingEntity(
                "Hongkong",
                "Rp 10.000 / 1 MB",
                380000
            )
        )
        list.add(
            RoamingEntity(
                "Jepang",
                "Rp 10.000 / 1 MB",
                660000
            )
        )
        list.add(
            RoamingEntity(
                "Korea Selatan",
                "Rp 10.000 / 1 MB",
                350000
            )
        )
        list.add(
            RoamingEntity(
                "Australia",
                "Rp 10.000 / 1 MB",
                600000
            )
        )
        list.add(
            RoamingEntity(
                "Taiwan",
                "Rp 10.000 / 1 MB",
                400000
            )
        )
        list.add(
            RoamingEntity(
                "China",
                "Rp 11.000 / 1 MB",
                220000
            )
        )
        list.add(
            RoamingEntity(
                "Arab Saudi",
                "Rp 10.000 / 1 MB",
                300000
            )
        )
        return list
    }
}