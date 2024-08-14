package de.unibi.citec.clf.bonsai_nodes

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.annotations.NonNls
import java.beans.PropertyChangeListener
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import com.intellij.openapi.util.UserDataHolderBase

class BonsaiNodeEditor(project: Project?, file: VirtualFile?) : FileEditor {

    private val userData = UserDataHolderBase()
    private val editorPanel: JPanel

    init {
        editorPanel = JPanel()
        val label = JLabel("Hello World")
        editorPanel.add(label)
    }

    override fun getComponent(): JComponent {
        return editorPanel
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return editorPanel
    }

    override fun getName(): String {
        return "Node Editor"
    }

    override fun setState(state: FileEditorState) {}
    override fun isModified(): Boolean {
        return false
    }

    override fun isValid(): Boolean {
        return true
    }

    override fun addPropertyChangeListener(listener: PropertyChangeListener) {}
    override fun removePropertyChangeListener(listener: PropertyChangeListener) {}

    override fun <T : Any?> getUserData(key: Key<T>): T? {
        return userData.getUserData(key)
    }

    override fun <T : Any?> putUserData(key: Key<T>, value: T?) {
        userData.putUserData(key, value)
    }

    override fun dispose() {}
}

