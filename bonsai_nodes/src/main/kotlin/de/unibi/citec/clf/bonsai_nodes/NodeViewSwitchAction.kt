package de.unibi.citec.clf.bonsai_nodes

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileEditor.FileEditorManager

class NodeViewSwitchAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        val file = e.dataContext.getData(CommonDataKeys.VIRTUAL_FILE)
        if (project != null && file != null) {
            val editorManager = FileEditorManager.getInstance(project)
            val editors = editorManager.getEditors(file)
            for (editor in editors) {
                if (editor is BonsaiNodeEditor) {
                    editorManager.setSelectedEditor(file, "bonsai.node.editor")
                    break
                }
            }
        }
    }
}