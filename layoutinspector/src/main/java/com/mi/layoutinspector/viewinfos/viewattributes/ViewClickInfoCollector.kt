package com.mi.layoutinspector.viewinfos.viewattributes

import android.view.View
import android.view.ViewGroup
import com.mi.layoutinspector.inspect.ViewInspector

/**
 * create by niuxiaowei
 * date : 22-1-18
 * view点击事件信息收集器
 **/
class ViewClickInfoCollector : IViewAttributeCollector {
    override fun collectViewAttributes(inspectedView: View, viewInspector: ViewInspector): List<ViewAttribute>? {
        val result = arrayListOf<ViewAttribute>()
        result.add(ViewAttribute("view属性", "点击不显示view属性界面", View.OnClickListener {
            viewInspector.setClickable(false)
            viewInspector.hideViewInfosPopupWindown()
        }))
        result.add(ViewAttribute("是否设置点击事件", if (inspectedView.hasOnClickListeners()) "是" else "否"))
        return result
    }
}