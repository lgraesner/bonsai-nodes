package de.unibi.citec.clf.bonsai_nodes
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile


class BonsaiNodeEditorFileProvider : FileEditorProvider {
    override fun accept(project: Project, file: VirtualFile): Boolean {
        val types = listOf("XML","SCXML")
        return file.fileType.name.toUpperCase() in types
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return BonsaiNodeEditor(project, file)
    }

    override fun getEditorTypeId(): String {
        return "bonsai.node.editor"
    }

    override fun getPolicy(): FileEditorPolicy {
        return FileEditorPolicy.HIDE_OTHER_EDITORS
    }
}


