package viet.hoang.automationproject.ui.control

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import viet.hoang.automationproject.adapters.HistoryAdapter
import viet.hoang.automationproject.databinding.FragmentControlBinding

class ControlFragment : Fragment() {

    private var _binding: FragmentControlBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val controlViewModel: ControlViewModel by viewModels()
    lateinit var mainHandler: Handler

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        controlViewModel =
//            ViewModelProvider(this).get(ControlViewModel::class.java)

        mainHandler = Handler(Looper.getMainLooper())
        _binding = FragmentControlBinding.inflate(inflater, container, false)
        val historiesRecyclerView: RecyclerView = binding.history
        var adapter = HistoryAdapter()
        historiesRecyclerView.adapter = adapter
        val root: View = binding.root

        controlViewModel.histories.observe(viewLifecycleOwner) {
            adapter.dataSet = it
            adapter.notifyDataSetChanged()
        }

        val buttonAdd = binding.btnAdd
        var nsx = binding.nsx
        val hsd = binding.hsd
        buttonAdd.setOnClickListener { controlViewModel.add(nsx.text.toString(), hsd.text.toString()) }

        val nsxTextView: TextView = binding.nsx
        controlViewModel.nsx.observe(viewLifecycleOwner) {
            nsxTextView.text = it
        }
        val hsdTextView: TextView = binding.hsd
        controlViewModel.nsx.observe(viewLifecycleOwner) {
            hsdTextView.text = it
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(fetchData)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainHandler.removeCallbacks(fetchData)
        _binding = null
    }

    private val fetchData = object : Runnable {
        override fun run() {
            controlViewModel.getData()
            mainHandler.postDelayed(this, 5000)
        }
    }
}
